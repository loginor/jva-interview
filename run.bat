docker build -t duration-formatter .

echo Running the Docker container...
docker run -p 8080:8080 duration-formatter

pause