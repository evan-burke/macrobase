IMPORT FROM CSV FILE 'src/test/resources/diff-joins/R4.csv' into R(A1 string);
IMPORT FROM CSV FILE 'src/test/resources/diff-joins/S4.csv' into S(A1 string);
IMPORT FROM CSV FILE 'src/test/resources/diff-joins/T4.csv' into T(A1 string, state string);
SELECT * FROM DIFF (SELECT * FROM R NATURAL JOIN T), (SELECT * FROM S NATURAL JOIN T) ON state WITH MIN SUPPORT 0.01;
