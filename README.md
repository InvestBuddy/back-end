# Getting Started

welcome to investBuddy microservices

### Guides

- first configure each application.properties file with correct data name, user and password.
By the way, I'm using Postgresql, but you can add mysql dependency and use it if you want :)
- run `docker compose up -d` to install and run kafka and zookeeper, of course you have to install docker first.
- If you want to create new user please use this email address `lsifstt22@gmail.com` to receive the verification email because i use Mailgun (sandbox) for sending email and i and i already allow this email to receive email message from my Mailgun sandbox.
- user-service communicate with notification-service by kafka (async comm) to send email after register.
- user-profile-service communicate with user-service by webClient (sync comm) to know if there is an existing user before create a new profile.
- don't forget to check the server port before testing :)

### For any issues or suggestions, please let me know