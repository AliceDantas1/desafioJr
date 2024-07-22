-- calculaNDO a média salarial de cada funcionário para os últimos 3 meses
WITH AverageSalaries AS (
    SELECT
        e.id,
        e.name,
        AVG(s.value) AS average_salary
    FROM
        employee e
    JOIN
        salary s ON e.id = s.employee_id
    WHERE
        s.payment_date >= CURDATE() - INTERVAL 3 MONTH
    GROUP BY
        e.id, e.name
),

-- selecionaNDO os três funcionários com as maiores médias salariais
Top3Salaries AS (
    SELECT
        id,
        name,
        average_salary
    FROM
        AverageSalaries
    ORDER BY
        average_salary DESC
    LIMIT 3
)

-- Finalmente, retorna o id e o nome dos três funcionários com as maiores médias salariais
SELECT
    id,
    name
FROM
    Top3Salaries;
