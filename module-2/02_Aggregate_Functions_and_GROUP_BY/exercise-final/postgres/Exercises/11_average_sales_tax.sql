-- 11. The average sales tax of all states, territories, and districts. Name the column 'average_sales_tax'.
-- Expected answer is around 4.9%
-- (1 row)

SELECT AVG(sales_tax) AS average_sales_tax
FROM state;
