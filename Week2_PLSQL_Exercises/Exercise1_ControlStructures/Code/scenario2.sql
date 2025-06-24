SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Customer ID ' || rec.CustomerID || ' marked as VIP.');
        END IF;
    END LOOP;

    COMMIT;
END;
/