var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(37.4899, 127.0290),
	level: 3
};

var map = new kakao.maps.Map(container, options);

var markerPosition = new kakao.maps.LatLng(37.5001, 127.0290);

var marker = new kakao.maps.Marker({
	position: markerPosition
});

marker.setMap(map);

var iwContent = '<div style="padding:5px;text-align:center; width:150px; height:75px; font-size:0.8em; font-weight:600;"><b style="font-size:1.2em;">그린도서관</b><br>(장연빌딩 1~4층)<hr><a href="https://map.kakao.com/link/map/그린도서관,37.5001, 127.0290" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/그린도서관,37.5001, 127.0290" style="color:blue" target="_blank">길찾기</a></div>',
	iwPosition = new kakao.maps.LatLng(37.5001, 127.0290);

var infowindow = new kakao.maps.InfoWindow({
	position: iwPosition,
	content: iwContent
});

infowindow.open(map, marker);
