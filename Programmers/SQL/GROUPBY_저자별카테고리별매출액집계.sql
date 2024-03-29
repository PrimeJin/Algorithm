-- 코드를 입력하세요
SELECT  b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, SUM(s.SALES * b.PRICE) as TOTAL_SALES
FROM BOOK b LEFT JOIN AUTHOR a ON (b.AUTHOR_ID = a.AUTHOR_ID)
      LEFT JOIN BOOK_SALES s ON (b.BOOK_ID = s.BOOK_ID)
WHERE s.SALES_DATE like '2022-01%'
GROUP BY b.AUTHOR_ID, b.CATEGORY
ORDER BY AUTHOR_ID ASC, CATEGORY DESC;