package com.wlc.ds.Stack;

public class Hannotower {
	public SimpleStack<Integer> disks;
	private String name;

	public Hannotower(SimpleStack<Integer> disks, String name) {
		this.disks = disks;
		this.name = name;
	}

	public void moveTopTo(Hannotower t) {
		int top = disks.peek();
		Integer n = t.disks.peek();
		if (n != null && n < top) {
			System.out.println("不能移动到此塔上！");
			return;
		}

		disks.pop();
		t.disks.push(top);
		System.out.println("将盘子 " + top + " 从 " + this.name + " 移动到 " + t.name
				+ " 上");
	}

	public void moveDisksTo(int n, Hannotower destination, Hannotower temp) {
		if (n > 0) {
			moveDisksTo(n - 1, temp, destination);
			moveTopTo(destination);
			temp.moveDisksTo(n - 1, destination, this);
		}
	}

}
