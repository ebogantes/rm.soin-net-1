package com.soin.sgrm.service.wf;

import java.util.List;

import com.soin.sgrm.model.wf.WorkFlow;

public interface WorkFlowService {

	List<WorkFlow> list();

	WorkFlow findById(Integer id);

	void save(WorkFlow workFlow);

	void update(WorkFlow workFlow);

	void delete(Integer id);

}
