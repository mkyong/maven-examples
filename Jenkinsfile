import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.model.Actionable;


def notifyBuild(String buildStatus = 'STARTED', String channel = '#jenkins-ci-int') {
    // build status of null means successful
    buildStatus =  buildStatus ?: 'SUCCESSFUL'

    
  // buildStatus of null means successfull
  buildStatus = buildStatus ?: 'SUCCESSFUL'
  channel = channel ?: '#jenkins-ci-int'


  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}] (<${env.RUN_DISPLAY_URL}|Open>) (<${env.RUN_CHANGES_DISPLAY_URL}|  Changes>)'"
  def title = "${env.JOB_NAME} Build: ${env.BUILD_NUMBER}"
  def title_link = "${env.RUN_DISPLAY_URL}"
  def branchName = "${env.BRANCH_NAME}"
 
  def commit = sh(returnStdout: true, script: 'git rev-parse HEAD')
  def author = sh(returnStdout: true, script: "git --no-pager show -s --format='%an'").trim()
  def branch1 = sh(returnStdout: true, script: 'git name-rev --name-only HEAD').tokenize('/')
  def message = sh(returnStdout: true, script: 'git log -1 --pretty=%B').trim()

  // Override default values based on build status
  if (buildStatus == 'SUCCESSFUL') {
    color = 'GREEN'
    colorCode = 'good'
  } else if (buildStatus == 'UNSTABLE') {
    color = 'YELLOW'
    colorCode = 'warning'
  } else {
    color = 'RED'
    colorCode = 'danger'
  }

  // get test results for slack message
  @NonCPS
  def getTestSummary = {
    def testResultAction = currentBuild.rawBuild.getAction(AbstractTestResultAction.class)
    def summary = ""

    if (testResultAction != null) {
        def total = testResultAction.totalCount
        def failed = testResultAction.failCount
        def skipped = testResultAction.skipCount

        summary = "Test results:\n\t"
        summary = summary + ("Passed: " + (total - failed - skipped))
        summary = summary + (", Failed: " + failed + " ${testResultAction.failureDiffString}")
        summary = summary + (", Skipped: " + skipped)
    } else {
        summary = "No tests found"
    }
    return summary
  }
  def testSummaryRaw = getTestSummary()
  // format test summary as a code block
  def testSummary = "```${testSummaryRaw}```"
  println testSummary.toString()

  JSONObject attachment = new JSONObject();
  attachment.put('author',"jenkins");
  attachment.put('author_link',"https://github.com/ziyanakthar");
  attachment.put('title', title.toString());
  attachment.put('title_link',title_link.toString());
  attachment.put('text', subject.toString());
  attachment.put('fallback', "fallback message");
  attachment.put('color',colorCode);
  attachment.put('mrkdwn_in', ["fields"])
  // JSONObject for branch
  JSONObject branch = new JSONObject();
  branch.put('title', 'Branch');
  branch.put('value', branch1[2]);
  branch.put('short', true);
  // JSONObject for author
  JSONObject commitAuthor = new JSONObject();
  commitAuthor.put('title', 'Author');
  commitAuthor.put('value', author.toString());
  commitAuthor.put('short', true);
  // JSONObject for branch
  JSONObject commitMessage = new JSONObject();
  commitMessage.put('title', 'Commit Message');
  commitMessage.put('value', message.toString());
  commitMessage.put('short', false);
  // JSONObject for test results
  JSONObject testResults = new JSONObject();
  testResults.put('title', 'Test Summary')
  testResults.put('value', testSummary.toString())
  testResults.put('short', false)
  attachment.put('fields', [branch, commitAuthor, commitMessage, testResults]);
  JSONArray attachments = new JSONArray();
  attachments.add(attachment);
  println attachments.toString()
  println branch.toString()
  println branch1[2]
  //println getGitBranchName()

  // Send notifications
  slackSend (color: colorCode, message: subject, attachments: attachments.toString(), channel: channel)
    }

//def getGitBranchName() {
//    return scm.branches[0].name
//}    
    
node('master'){
   stage ('Checkout') {
        checkout([$class: 'GitSCM', branches: [[name: '*/develop'], [name: '*/master'], [name: '*/release']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ziyanakthar/maven-examples.git']]])
    }
    
    stage ('Build') {
        try {
          //  notifyBuild()

            dir("./") {
                sh 'pwd && ls -ltr && cd maven-unit-test && ls -ltr && mvn test && mvn install'
                junit allowEmptyResults: true, keepLongStdio: true, skipMarkingBuildUnstable: true, skipPublishingChecks: true, testResults: '**/target/surefire-reports/*.xml'
            }
        } catch (e) {
            // If there was an exception thrown, the build failed
            currentBuild.result = "FAILED"
            throw e
        } finally {
            // Success or failure, always send notifications
            notifyBuild(currentBuild.result)
        }
    }
}
