-- 8. The area of the state with the smallest population in the "Northeast" census region. Name the column 'smallest_northeast_area'.
-- Expected answer is around 4,000
-- (1 row)

SELECT MIN(area) AS smallest_northeast_area
FROM state
WHERE census_region = 'Northeast';
