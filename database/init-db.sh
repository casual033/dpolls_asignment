docker cp polls.json dpolls-db-mongo:/tmp/polls.json
docker exec dpolls-db-mongo mongoimport --db=dpolls --collection=polls --file=/tmp/polls.json --jsonArray --drop
