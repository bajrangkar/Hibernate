GenNow is a ID Generator, which takes parameters
•	startAt (the starting int value of the ID)
•	gap (this parameter lets you control the gap between two ids generator)
•	tablename (the table name which keeps the last geenrated int id)
•	prefix (String, which added before the ID generated)
•	suffix (String, which added after the ID generated)

CONS : Queries are hardcoded, which are only suitable for mySql.

TODO :
•	Make GenNow class comapatible to all DBs.
•	Implement default tablename, which decides the tablename based on the Entity name [Added on 27-04-2016]
•	Make SUFFIX and PREFIX as new parameters [Added on 27-04-2016]
•	Add parameter to add 0s in the ID generated, which will make the length of the IDs fix [Fixed round off to 5 digits]

