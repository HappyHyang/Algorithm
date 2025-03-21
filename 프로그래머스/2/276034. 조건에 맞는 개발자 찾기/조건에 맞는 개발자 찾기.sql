SELECT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM
    DEVELOPERS
WHERE
    ID IN (
        SELECT
            DISTINCT D.ID
        FROM
            DEVELOPERS D
        JOIN SKILLCODES S ON D.SKILL_CODE & S.CODE = S.CODE
        WHERE S.NAME = 'C#'
           OR S.NAME = 'Python')
ORDER BY
    ID