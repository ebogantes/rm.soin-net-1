package com.soin.sgrm.service;

import com.soin.sgrm.model.Release;
import com.soin.sgrm.model.ReleaseObject;
import com.soin.sgrm.model.ReleaseObjectEdit;

public interface ReleaseObjectService {

	Release findReleaseToAddByObject(ReleaseObjectEdit obj, Release release);

	Release findReleaseToDeleteByObject(Release release, ReleaseObject obj);

	ReleaseObjectEdit saveObject(ReleaseObjectEdit rObj, Release release) throws Exception;

	ReleaseObjectEdit findById(Integer id);

	void deleteObject(Integer releaseId, ReleaseObject object) throws Exception;
}
