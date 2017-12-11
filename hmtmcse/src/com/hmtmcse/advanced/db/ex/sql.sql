SELECT TABLE_NAME,ENGINE,TABLE_COLLATION FROM information_schema.TABLES where TABLE_SCHEMA = 'grails_lib_management';
DESCRIBE assign_task;


use INFORMATION_SCHEMA;


SELECT TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME,REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s' AND referenced_column_name IS NOT NULL;


grails_lib_management


select table_name from information_schema.tables where table_schema='<your_database_name>';
SELECT * FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'grails_lib_management';

SELECT TABLE_NAME,ENGINE,TABLE_COLLATION FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'grails_lib_management';












SELECT

sTable.TABLE_NAME,
sTable.ENGINE,
sTable.TABLE_COLLATION,
KCU.COLUMN_NAME,
KCU.CONSTRAINT_NAME,
KCU.REFERENCED_TABLE_NAME,
KCU.REFERENCED_COLUMN_NAME

FROM information_schema.TABLES as sTable LEFT JOIN information_schema.KEY_COLUMN_USAGE as KCU ON sTable.TABLE_NAME = KCU.TABLE_NAME WHERE sTable.TABLE_SCHEMA = 'grails_lib_management';

SELECT * FROM information_schema.KEY_COLUMN_USAGE as KCU WHERE TABLE_SCHEMA = 'grails_lib_management';