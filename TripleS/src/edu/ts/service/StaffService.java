package edu.ts.service;

import edu.ts.entity.Staff;

public interface StaffService {
	/**
     * 员工登录
     *
     * @param staff
     * @return 成功true 失败false
     */
    public boolean login(Staff staff);
}
