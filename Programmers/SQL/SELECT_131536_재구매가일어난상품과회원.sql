-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE  
GROUP BY USER_ID, PRODUCT_ID  #동일한 회원이 동일한 상품 재구매
HAVING COUNT(USER_ID) > 1  # 구매횟수 2이상
ORDER BY USER_ID ASC, PRODUCT_ID DESC;