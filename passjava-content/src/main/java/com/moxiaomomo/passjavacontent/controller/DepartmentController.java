package com.moxiaomomo.passjavacontent.controller;

import com.moxiaomomo.passjavacontent.entity.Department;
import com.moxiaomomo.passjavacontent.mapper.DepartmentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "DepartmentController", description = "部门controller")
@RequestMapping("/v1/client")
@RestController
public class DepartmentController {
    // static:只创建1次, final:不可更改
    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentMapper departmentMapper;

    @ApiOperation(value = "1.查询所有部门")
    @GetMapping("/dept/getAllDepartment")
    public List<Map<String, Object>> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }

    @ApiOperation(value = "2.根据id查询某个部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "需要查询的部门id")
    })
    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentMapper.getDepartmentById(id);
    }

    @ApiOperation(value = "3.新增部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "部门名称")
    })
    @PostMapping("/dept/create")
    public int createDepartment(@RequestParam String name) {
        return departmentMapper.createDepartment(name);
    }

    @ApiOperation(value = "4.根据id删除部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "需要删除的部门id")
    })
    @PostMapping("/dept/delete")
    public int deleteDepartment(@RequestParam Long id) {
        return departmentMapper.deleteDepartment(id);
    }

    @ApiOperation(value = "5.根据id更新部门名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "需要更新的部门id"),
            @ApiImplicitParam(name = "name", value = "需要更新的部门名称")
    })
    @PostMapping("/dept/update")
    public int updateDepartmentById(@RequestParam Long id, @RequestParam String name) {
        return departmentMapper.updateDepartmentById(id, name);
    }
}