SELECT SORTE, MIN(PREIS) 
FROM st_01_pflanzen_pflanzen 
WHERE bl_b >= 5 and bl_e <= 6
GROUP BY SORTE;