/*
 * Created Date: 2021-12-10 14:28:46
 * Author: allendeng
 * -----
 * Last Modified: 2021-12-10 15:24:47
 * Modified By: haoyuan
 * -----
 * Copyright (C) 2021 MetaHospital, Inc. All Rights Reserved.
 *
 * -----
 */
package com.metahospital.datacollector.dao;

import com.metahospital.datacollector.aop.handler.CollectorException;
import com.metahospital.datacollector.common.RestCode;
import com.metahospital.datacollector.dao.data.Profile;
import com.metahospital.datacollector.dao.data.User;
import com.metahospital.datacollector.dao.data.UserProfile;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserProfileDao {

    public List<UserProfile> getAll(long userId) {
        SqlSession sqlSession = MysqlDao.getSqlSession();
        try {
            Map<String, Object> map = new HashMap();
            map.put("userId", userId);
            List<UserProfile> list = sqlSession.selectList("UserProfileMapper.getAll", map);
            if (list == null || list.isEmpty()) {
                return Collections.emptyList();
            }
            return list;
        } catch (CollectorException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CollectorException(RestCode.PARAM_INVALID_ERR, e.getLocalizedMessage());
        } finally {
            MysqlDao.closeSqlSession();
        }
    }

    public UserProfile get(long userId, int hospitalId, long profileId) {
        SqlSession sqlSession = MysqlDao.getSqlSession();
        try {
            Map<String, Object> map = new HashMap();
            map.put("userId", userId);
            map.put("hospitalId", hospitalId);
	        map.put("profileId", profileId);
            List<UserProfile> list = sqlSession.selectList("UserProfileMapper.get", map);
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list.get(0);
        } catch (CollectorException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CollectorException(RestCode.PARAM_INVALID_ERR, e.getLocalizedMessage());
        } finally {
            MysqlDao.closeSqlSession();
        }
    }

	public void replace(UserProfile userProfile) {
	    SqlSession sqlSession = MysqlDao.getSqlSession();
        try {
            sqlSession.update("UserProfileMapper.replace", userProfile);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            e.printStackTrace();
            throw new CollectorException(RestCode.PARAM_INVALID_ERR, e.getLocalizedMessage());
        } finally {
            MysqlDao.closeSqlSession();
        }
    }
    
}
