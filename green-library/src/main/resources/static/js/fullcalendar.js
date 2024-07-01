document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          selectable: true,
			events:[{
				title:'휴관일',
				start:'2024-05-06',
				backgroundColor:'orange',
				borderColor:'orange',
				url:"/schedule"
		    },
		    {
				title:'휴관일',
				start:'2024-05-20',
				backgroundColor:'orange',
				borderColor:'orange',
				url:"/schedule"
		    },
			{
				title:'휴관일',
				start:'2024-06-03',
				backgroundColor:'orange',
				borderColor:'orange',
				url:"/schedule"
		    },
		    {
			    title:'휴관일',
			    start:'2024-06-17',
			    backgroundColor:'orange',
			    borderColor:'orange',
				url:"/schedule"
		    },
			{
			    title:'휴관일',
			    start:'2024-07-01',
			    backgroundColor:'orange',
			    borderColor:'orange',
				url:"/schedule"
		    },
			{
			    title:'휴관일',
			    start:'2024-07-15',
			    backgroundColor:'orange',
			    borderColor:'orange',
				url:"/schedule"
		    },
			{
			    title:'휴관일',
			    start:'2024-07-29',
			    backgroundColor:'orange',
			    borderColor:'orange',
				url:"/schedule"
		    },
		]
 
          

        });
       
        calendar.render();

       
      });