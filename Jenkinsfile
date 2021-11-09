pipeline {
    agent { label "master" }

    triggers { pollSCM 'H/5 * * * *' }
        
    options {
        skipDefaultCheckout true // Allows us to clean house before actual git pull
    }

    environment { // A good place to put high visibility/commit-changing variables
        SLACK_MESSAGE_CHANNEL = "slack-testing"
        SLACK_SUCCESS_COLOR = "#00FF00" // Green
        SLACK_UNSTABLE_COLOR = "#FFFF00" // Yellow
        SLACK_FAIL_COLOR = "#FF0000" // Red
        CONFIG_FILE_NAME = "config.xml"
    }

    stages {
        stage ("Initialization") {
            steps {
                cleanWs() // Clean house
            }
        }
        stage ("Maven Tests") {
            steps {
                sh  'git clone https://github.com/ziyanakthar/maven-examples.git && pwd && cd maven-examples/maven-unit-test && ls -ltr && mvn test && mvn install'
            }
                               
      
            post {
                 failure {
                    slackSend (color: '#FF0000', message: """FAILED:
Job: ${env.JOB_NAME}
Build #${env.BUILD_NUMBER}
Build: ${env.BUILD_URL}'""")
    }
                 success {
                    slackSend (color: '#00FF00', message: """SUCCESS:
Job: ${env.JOB_NAME}
Build #${env.BUILD_NUMBER}
Build: ${env.BUILD_URL}'""")
                 }
            }
        }
    }
}
