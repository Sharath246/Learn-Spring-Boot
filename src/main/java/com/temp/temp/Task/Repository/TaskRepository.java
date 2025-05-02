package com.temp.temp.Task.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.temp.temp.Task.Entity.Auditlog;
import com.temp.temp.Task.Entity.Task;

@Repository
public class TaskRepository {
    private final JdbcTemplate jdbc;

    public TaskRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public RowMapper<Long> UserRowMapper = new RowMapper<Long>() {
        @Override
        public Long mapRow(ResultSet rs, int row) throws SQLException{
            return rs.getLong("userid");
        }
    };

    public List<Long> allUsersForTask(String taskId){
        String sql = "select * from tasks where id = '"+ taskId + "';";
        try{
            List<Long> allusers = jdbc.query(sql, UserRowMapper);
            return allusers;
        }
        catch(Exception exception){
            System.err.println(exception.getMessage());
            return null;
        }
    }

    public String createTask(Task task){
        String sql = "insert into tasks (title,description,status,priority,duedate,createddate,updateddate) values (?,?,?,?,?,?,?)";
        try{
            jdbc.update(sql, task.getTitle(), task.getDescription(), task.getStatus(),task.getPriority(),task.getDuedate(),task.getCreateddate(), task.getUpdateddate());
            return "Success";
        }
        catch(Exception exception){
            System.err.println(exception.getMessage());
            return "Failed";
        }
    }

    public String appendLog(Auditlog log){
        String sql = "insert into auditlog (action,entity,entityid,user,timestamp) values (?,?,?,?,?)";
        try {
            jdbc.update(sql,log.getAction(),log.getEntity(),log.getEntityid(),log.getUser(),log.getTimestamp());
            return "Success";
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            return "Failed";
        }
    }

    

}
