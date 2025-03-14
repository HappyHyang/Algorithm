SELECT
    P.ID,
    P.NAME,
    P.HOST_ID
FROM
    PLACES P
JOIN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) > 1
) AS HEAVY_USERS ON P.HOST_ID = HEAVY_USERS.HOST_ID
ORDER BY
    P.ID