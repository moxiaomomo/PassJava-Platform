package com.moxiaomomo.passjavacontent.entity;

public class Department {
        private Long id;
        private String departmentName;

        public void setId(Long id) {
                this.id = id;
        }

        public Long getId() {
                return id;
        }

        public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
        }

        public String getDepartmentName() {
                return departmentName;
        }
}
