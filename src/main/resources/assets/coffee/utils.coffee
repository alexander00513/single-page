activateMenu = (elementId) ->
  $('ul li.active').removeClass('active')
  $('#' + elementId).addClass('active')

initButtons = () ->
  $("#clear").click((event) ->
    $('#content').text('This is a simple single page application')
    activateMenu('clear')
  );
  $("#department").click((event) ->
    $('#content').text('department.html')
    activateMenu('department')
  );
  $("#employee").click((event) ->
    $('#content').text('employee.html')
    activateMenu('employee')
  );

initDepartmentTable = () ->
  $('#departmentTable').DataTable({
    "ajax": "../../department",
    "sAjaxDataProp": "",
    "columns": [
      {"data": "id"},
      {"data": "title"}
    ]
  });

initEmployeeTable = () ->
  $('#employeeTable').DataTable({
    "ajax": "../../employee",
    "sAjaxDataProp": "",
    "columns": [
      {"data": "id"},
      {"data": "firstName"},
      {"data": "lastName"},
      {"data": "salary"},
      {"data": "birthday"},
      {"data": "active"},
      {"data": "department.title"}
    ],
    columnDefs: [
      {
        "render": (data, type, row) ->
          return data + '$'
        "targets": 3
      },
      {
        "render": (data, type, row) ->
          isChecked = data ? 'checked': ''
          return '<input type="checkbox" ' + isChecked + ' disabled>'
        "targets": 5
      }
    ]
  });
