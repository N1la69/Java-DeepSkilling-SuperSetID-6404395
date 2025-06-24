CREATE OR REPLACE PROCEDURE TransferFunds(
    from_account IN NUMBER,
    to_account IN NUMBER,
    amt IN NUMBER
) AS 
    source_bal NUMBER;
BEGIN
    SELECT BALANCE INTO source_bal
    FROM ACCOUNTS
    WHERE ACCOUNTID = from_account;

    IF (source_bal < amt) THEN 
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance in Account ID: ' || from_account);
    ELSE
        UPDATE ACCOUNTS
        SET BALANCE = BALANCE - amt, LastModified = SYSDATE
        WHERE ACCOUNTID = from_account;

        UPDATE ACCOUNTS
        SET BALANCE = BALANCE + amt, LastModified = SYSDATE
        WHERE ACCOUNTID = to_account;

        DBMS_OUTPUT.PUT_LINE('Transfer of ' || amt || ' from Account ID ' || from_account || ' to Account ID ' || to_account || ' successful.');

        COMMIT;
    END IF;
END;
/

BEGIN
    TransferFunds(1, 2, 500);
END;
/