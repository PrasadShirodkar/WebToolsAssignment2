/**
 * @author Prasad
 */
function confirmClearSearchResults() {
	
	if(confirm("Do you really want to clear all search results?")) {
		return true;
	} else {
		return false;
	}
}