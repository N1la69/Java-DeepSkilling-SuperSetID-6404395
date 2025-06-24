SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_customers IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB)/12 > 60;

BEGIN
    FOR rec IN cur_customers LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - (InterestRate * 0.01)
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('1% discount applied to Loan ID ' || rec.LoanID || ' for Customer ID ' || rec.CustomerID);
    END LOOP;

    COMMIT;
END;
/