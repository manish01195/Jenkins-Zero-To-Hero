def call() {
  sh '''
                sudo rm -rf .git/
                cd /var/www/html/api_dentalhut/
                sudo rsync -a /home/jenkins2/jenkins-agent/workspace/test-dev-be/behrms/ .
                sudo npm i
                cd /var/www/html/api_dentalhut/
                sudo cp /var/lib/db_config/hrms/default.json /var/www/html/api_dentalhut/config/.
                sudo chown ubuntu:ubuntu -R /var/www/html/
                sudo pm2 stop server.js 
                set NODE_ENV=development
                sudo pm2 start server.js 

                '''
}
