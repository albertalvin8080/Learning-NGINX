# This is a trick used to prevent the host volume folder from overriding the target folder inside the container on the first run.

FROM nginx:1.26
RUN mkdir /etc/nginx_backup && cp -R /etc/nginx/* /etc/nginx_backup/
CMD if [ -z "$(ls -A /etc/nginx)" ]; then cp -R /etc/nginx_backup/* /etc/nginx/; fi && nginx -g 'daemon off;'

# `nginx -g 'daemon off;'` explained: When running Nginx inside a Docker container or for debugging purposes, it’s recommended to use the daemon off; directive. This is because Docker containers are usually designed to run a single primary process per container. When you set daemon off;, it instructs Nginx to run in the foreground, which means it becomes the primary process in the container