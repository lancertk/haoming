package com.cn.jingfen.mapper;

import java.util.List;
import java.util.Map;

import com.cn.jingfen.vo.Grid;
import com.cn.jingfen.vo.User;

public interface GridMapper {

//查询报表分类
public List selctGridType();
//查询所有数据
public List<Grid> selectAllGrid();
//查询最新时间
public List selctrefreshtime(Map<String, Object> map);

public List selctGrid1();

public List selctGrid2();

public List selctGridtest1(Map<String,Object> map);

public List selctGridtest2(Map<String,Object> map);

public List selctGridtest3(Map<String,Object> map);

public List selctGridtest4(Map<String,Object> map);


}
