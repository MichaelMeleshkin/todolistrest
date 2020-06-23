## Database setup
- [Install](http://postgresguide.com/setup/install.html) PostgreSQL database

- Create user 'admin' with password 'admin' and databases for services

`sudo -u postgres psql postgres`

`CREATE USER admin WITH PASSWORD 'admin';`

`CREATE DATABASE "todo_list";`

`GRANT ALL PRIVILEGES ON DATABASE "todo_list" to admin;`

- add SUPERUSER role to user 'admin'
 
 `ALTER ROLE admin SUPERUSER;`
 
## Development server

Run `gradlew build && java -jar build/libs/demo-0.0.1-SNAPSHOT.war` (or from your IDE) for a dev server. The server uses port `8090`.

## Lombok configuration for IntelliJ IDEA

- Install Lombok Plugin

Settings (Ctrl + Alt + S) / Plugin / Browse repositories / Type 'Lombok Plugin' and install it

- Enable annotation processing

Settings (Ctrl + Alt + S) / Build, Execution, Deployment / Compiler / Annotation Processors / Enable annotation processing

## Test User

Username: johndoe

Password: admin
