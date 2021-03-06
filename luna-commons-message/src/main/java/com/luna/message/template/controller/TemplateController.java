package com.luna.message.template.controller;

import com.github.pagehelper.PageInfo;
import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.message.template.pojo.TemplateDO;
import com.luna.message.template.service.TemplateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:luna
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "TemplateController")
@RestController
@RequestMapping("/template")
@CrossOrigin
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /***
     * Template分页条件搜索实现
     * @param templateDO
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Template条件分页查询", notes = "分页条件查询Template方法详情", tags = {"TemplateController"})
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Long"),
        @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Long")
    })
    @PostMapping(value = "/search/{page}/{size}")
    public ResultDTO<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Template对象",
        value = "传入JSON数据", required = false) TemplateDO templateDO, @PathVariable int page, @PathVariable int size) {
        // 调用TemplateService实现分页条件查询Template
        PageInfo<TemplateDO> pageInfo = templateService.findPage(templateDO, page, size);
        return new ResultDTO(true, ResultCode.SUCCESS, "查询成功", pageInfo);
    }

    /***
     * Template分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Template分页查询", notes = "分页查询Template方法详情", tags = {"TemplateController"})
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Long"),
        @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Long")
    })
    @GetMapping(value = "/search/{page}/{size}")
    public ResultDTO<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        // 调用TemplateService实现分页查询Template
        PageInfo<TemplateDO> pageInfo = templateService.findPage(page, size);
        return new ResultDTO<PageInfo>(true, ResultCode.SUCCESS, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索数据
     * @param templateDO
     * @return
     */
    @ApiOperation(value = "Template条件查询", notes = "条件查询Template方法详情", tags = {"TemplateController"})
    @PostMapping(value = "/search")
    public ResultDTO<List<TemplateDO>> findList(@RequestBody(required = false) @ApiParam(name = "Template对象",
        value = "传入JSON数据", required = false) TemplateDO templateDO) {
        // 调用TemplateService实现条件查询Template
        List<TemplateDO> list = templateService.findList(templateDO);
        return new ResultDTO<List<TemplateDO>>(true, ResultCode.SUCCESS, "查询成功", list);
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Template根据ID删除", notes = "根据ID删除Template方法详情", tags = {"TemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}")
    public ResultDTO delete(@PathVariable Long id) {
        // 调用TemplateService实现根据主键删除
        templateService.delete(id);
        return new ResultDTO(true, ResultCode.SUCCESS, "删除成功");
    }

    /***
     * 修改Template数据
     * @param templateDO
     * @param id
     * @return
     */
    @ApiOperation(value = "Template根据ID修改", notes = "根据ID修改Template方法详情", tags = {"TemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value = "/{id}")
    public ResultDTO update(
        @RequestBody @ApiParam(name = "Template对象", value = "传入JSON数据", required = false) TemplateDO templateDO,
        @PathVariable Long id) {
        // 设置主键值
        templateDO.setId(id);
        // 调用TemplateService实现修改Template
        templateService.update(templateDO);
        return new ResultDTO(true, ResultCode.SUCCESS, "修改成功");
    }

    /***
     * 新增Template数据
     * @param templateDO
     * @return
     */
    @ApiOperation(value = "Template添加", notes = "添加Template方法详情", tags = {"TemplateController"})
    @PostMapping
    public ResultDTO
        add(@RequestBody @ApiParam(name = "Template对象", value = "传入JSON数据", required = true) TemplateDO templateDO) {
        // 调用TemplateService实现添加Template
        templateService.add(templateDO);
        return new ResultDTO(true, ResultCode.SUCCESS, "添加成功");
    }

    /***
     * 根据ID查询Template数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Template根据ID查询", notes = "根据ID查询Template方法详情", tags = {"TemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResultDTO<TemplateDO> findById(@PathVariable Long id) {
        // 调用TemplateService实现根据主键查询Template
        TemplateDO templateDO = templateService.findById(id);
        return new ResultDTO<TemplateDO>(true, ResultCode.SUCCESS, "查询成功", templateDO);
    }

    /***
     * 查询Template全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Template", notes = "查询所Template有方法详情", tags = {"TemplateController"})
    @GetMapping
    public ResultDTO<List<TemplateDO>> findAll() {
        // 调用TemplateService实现查询所有Template
        List<TemplateDO> list = templateService.findAll();
        return new ResultDTO<List<TemplateDO>>(true, ResultCode.SUCCESS, "查询成功", list);
    }
}
