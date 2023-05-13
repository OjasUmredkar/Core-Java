package com.app.customer;

public enum ServicePlan {
		SILVER(1000),GOLD(2000),DAIMOND(5000),PLATINUM(10000);
		
		//super(name,ordinal): java.lang.Enum
		
		private double planCost;
		private ServicePlan(int planCost) {
			this.planCost=planCost;
		}
		
		@Override
		public String toString() {
			return name()+" cost:"+this.planCost;
		}
		
		public double getPlanCost() {
			return this.planCost;
		}
}
