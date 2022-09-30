package com.OperationsDAO;

import java.util.List;

import com.BeanClass.Batch;
import com.Exceptions.BatchException;

public interface BatchDAO {

	public List<Batch> getAllBatchDetaisl() throws BatchException;
}
