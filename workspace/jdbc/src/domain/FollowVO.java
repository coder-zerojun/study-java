package domain;

public class FollowVO {

	private Long followId;
	private Long followerId;
	private Long follwingId;
	
	
	public FollowVO() {;}


	public Long getFollowId() {
		return followId;
	}


	public void setFollowId(Long followId) {
		this.followId = followId;
	}


	public Long getFollowerId() {
		return followerId;
	}


	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}


	public Long getFollwingId() {
		return follwingId;
	}


	public void setFollwingId(Long follwingId) {
		this.follwingId = follwingId;
	}


	@Override
	public String toString() {
		return "FollowVO [followId=" + followId + ", followerId=" + followerId + ", follwingId=" + follwingId + "]";
	}
	
	
	
	
	
}
