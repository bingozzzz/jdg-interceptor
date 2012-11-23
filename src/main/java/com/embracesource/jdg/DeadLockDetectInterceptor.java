package com.embracesource.jdg;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.infinispan.commands.write.PutKeyValueCommand;
import org.infinispan.container.DataContainer;
import org.infinispan.context.InvocationContext;
import org.infinispan.factories.annotations.Inject;
import org.infinispan.interceptors.base.CommandInterceptor;
import org.infinispan.util.concurrent.locks.LockManager;

public class DeadLockDetectInterceptor extends CommandInterceptor {
	   LockManager lockManager;
	   DataContainer dataContainer;
	   private Map<String, Long> lockedMap = null;

	   @Inject
	   public void setDependencies(LockManager lockManager, DataContainer dataContainer) {
	      this.lockManager = lockManager;
	      this.dataContainer = dataContainer;
	      this.lockedMap = new ConcurrentHashMap<String, Long>(16,0.75f,1000);
	   }
	   
	   
	   
	   @Override
	   public Object visitPutKeyValueCommand(InvocationContext ctx, PutKeyValueCommand command) throws Throwable {
	      return null;
	   }

	  

}
