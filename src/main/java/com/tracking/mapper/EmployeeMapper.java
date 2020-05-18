package com.tracking.mapper;

import com.tracking.dto.EmployeeDto;
import com.tracking.model.Department;
import com.tracking.model.Employee;
import com.tracking.model.Post;
import com.tracking.service.DepartmentService;
import com.tracking.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Service
public class EmployeeMapper extends AbstractMapper<Employee, EmployeeDto> {

    private ModelMapper modelMapper;

    private DepartmentService departmentService;
    private PostService postService;
    @Autowired
    public EmployeeMapper(ModelMapper modelMapper, DepartmentService departmentService, PostService postService) {
        super(Employee.class, EmployeeDto.class, modelMapper);
        this.departmentService = departmentService;
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initMapper() {
        modelMapper.createTypeMap(Employee.class, EmployeeDto.class)
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(EmployeeDto.class, Employee.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(EmployeeDto source, Employee destination) {
        Department department = departmentService.findById(source.getDepartmentId());
        destination.setDepartment(department);
        Post post = postService.findById(source.getPostId());
        destination.setPost(post);
    }

    @Override
    protected void mapSpecificFields(Employee source, EmployeeDto destination) {
        Post post = source.getPost();
        Long postId = Objects.isNull(post) ? null : post.getId();
        destination.setPostId(postId);
        Department department = source.getDepartment();
        Long departmentId = Objects.isNull(department) ? null : department.getId();
        destination.setDepartmentId(departmentId);
    }
}