pipeline {
    agent any
 stages {
        stage('CREATE_SNAPSHOT') {
            when {
                    expression { ACTION == 'CREATE_SNAPSHOT'}
                }
            steps {
                    sh 'aws ec2 create-snapshot --volume-id $volume_id --region $region'       
            }
        }
        
        stage('DELETE_SNAPSHOT') {
            when {
                    expression { ACTION == 'DELETE_SNAPSHOT'}
                }
            steps {
                    sh 'aws ec2 delete-snapshot --snapshot-id $snapshot_id --region $region'

                }
        }
    }
}
