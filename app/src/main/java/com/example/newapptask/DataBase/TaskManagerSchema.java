package com.example.newapptask.DataBase;

public class TaskManagerSchema {
    public static final String NAME="task_manager.db";
    public static final int VERSION=1;

    public static final class User{
        public static final String NAME="userTable";

        public static final class userColumns{
            public static final String ID="id";
            public static final String UUID="userId";
            public static final String USERNAME="username";
            public static final String PASSWORD="password";
            public static final String MEMBERSHIP="membership";
            public static final String ISADMINE="isadmin";

        }

    }
    public static final class TASK{
        public static final String NAME="taskTable";
        public static final class taskColumns{
            public static final String ID="id";
            public static final String UUID="taskId";
            public static final String TITLE="title";
            public static final String DESCRIPTION="description";
            public static final String DATE="date";
            public static final String TIME="time";
            public static final String STATE="state";
            public static final String USERID="userId";
            public static final String IMG_ADDRESS="image address";


        }
    }
}
