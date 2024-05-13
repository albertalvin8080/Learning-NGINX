FROM nginx:1.26

RUN apt-get update
RUN apt-get install --no-install-recommends -y apache2-utils

RUN mkdir -p /etc/http_basic_users/

# `-b`: Use the password from the command line rather than prompting for it.
RUN htpasswd -b -c /etc/http_basic_users/.htpasswd albert 1234