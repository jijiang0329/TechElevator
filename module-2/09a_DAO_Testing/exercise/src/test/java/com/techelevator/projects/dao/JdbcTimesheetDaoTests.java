package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_returns_correct_timesheet_for_id() {
        Timesheet timesheetFromDB = dao.getTimesheetById(1);
        assertTimesheetsMatch(TIMESHEET_1, timesheetFromDB);
    }

    @Test
    public void getTimesheetById_returns_null_when_id_not_found() {
        Timesheet timesheetFromDB = dao.getTimesheetById(100);
        Assert.assertNull(timesheetFromDB);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(2);
        Assert.assertEquals(2, timesheets.size());
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> results = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals(3, results.size());
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet newTimesheet = new Timesheet();
        newTimesheet.setProjectId(1);
        newTimesheet.setEmployeeId(2);
        newTimesheet.setDateWorked(LocalDate.parse("2021-01-02"));
        newTimesheet.setHoursWorked(2.0);
        newTimesheet.setBillable(true);
        newTimesheet.setDescription("Timesheet 5");

        Timesheet createdTimesheet = dao.createTimesheet(newTimesheet);
        newTimesheet.setTimesheetId(createdTimesheet.getTimesheetId());

        assertTimesheetsMatch(newTimesheet, createdTimesheet);

        Timesheet retrievedTimesheet = dao.getTimesheetById(createdTimesheet.getTimesheetId());
        assertTimesheetsMatch(newTimesheet, retrievedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet updatedTimesheet = dao.getTimesheetById(4);
        updatedTimesheet.setEmployeeId(2);
        updatedTimesheet.setProjectId(2);
        updatedTimesheet.setDateWorked(LocalDate.parse("2021-01-03"));
        updatedTimesheet.setHoursWorked(2.5);
        updatedTimesheet.setBillable(false);
        updatedTimesheet.setDescription("Timesheet 6");

        Timesheet updated = dao.updateTimesheet(updatedTimesheet);
        assertTimesheetsMatch(updated, updatedTimesheet);

        Timesheet retrievedTimesheet = dao.getTimesheetById(4);
        assertTimesheetsMatch(updatedTimesheet, retrievedTimesheet);
    }

    @Test
    public void deleted_timesheet_can_no_longer_be_retrieved() {
        dao.deleteTimesheetById(1);

        Timesheet timesheet1 = dao.getTimesheetById(1);
        Assert.assertNull(timesheet1);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        //dao.getBillableHours(1,1);

        double billableHours = dao.getBillableHours(1,1);
        Assert.assertEquals(2.5, billableHours, 0.01);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
