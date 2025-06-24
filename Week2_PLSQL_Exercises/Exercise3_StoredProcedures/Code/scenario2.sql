CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) AS
BEGIN
    FOR rec IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = dept_name
    )
    LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * bonus_percent / 100)
        WHERE EmployeeID = rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || rec.EmployeeID);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/