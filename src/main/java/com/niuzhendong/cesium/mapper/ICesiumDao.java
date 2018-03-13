package com.niuzhendong.cesium.mapper;

import java.util.List;
import java.util.Map;

public interface ICesiumDao {

	public List<Map<String, String>> getUser(Map<String, String> param);
}
