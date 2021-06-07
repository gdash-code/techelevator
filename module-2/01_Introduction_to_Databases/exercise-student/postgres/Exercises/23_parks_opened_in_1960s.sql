-- 23. The name and date established of parks opened in the 1960s (6 rows)
SELECT park_name, date_established FROM park WHERE date_established BETWEEN '1/1/1960' AND '1/1/1969';
