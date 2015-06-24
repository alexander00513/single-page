function activateMenu(elementId) {
    $('ul li.active').removeClass('active');
    $('#' + elementId).addClass('active');
}

function initButtons() {
    $("#clear").click(function (event) {
        $('#content').text('This is a simple single page application');
        activateMenu('clear');
    });
    $("#department").click(function (event) {
        $('#content').load('department.html');
        activateMenu('department');
    });
    $("#employee").click(function (event) {
        $('#content').load('employee.html');
        activateMenu('employee');
    });
}

function initDepartmentTable() {
    $('#departmentTable').DataTable({
        "ajax": "../../department",
        "sAjaxDataProp": "",
        "columns": [
            {"data": "id"},
            {"data": "title"}
        ]
    });
}

function initEmployeeTable() {
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
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    return data + '$';
                },
                "targets": 3
            },
            {
                "render": function (data, type, row) {
                    var isChecked = data ? 'checked' : '';
                    return '<input type="checkbox" ' + isChecked + ' disabled>';
                },
                "targets": 5
            }
        ]
    });
}