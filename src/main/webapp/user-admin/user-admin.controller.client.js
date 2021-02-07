var $usernameFld;
var $passwordFld;
var $firstNameFld;
var $lastNameFld;
var $roleFLd;
var $studentTableBody;
var $searchBtn;
var $createBtn;
var $updateBtn;

let init = () => {
    $usernameFld = $("#username");
    $passwordFld = $("#password");
    $firstNameFld = $("#first-name");
    $lastNameFld = $("#last-name");
    $roleFLd = $("#role");
    $studentTableBody = $(".wbdv-tbody");
    $searchBtn = $(".wbdv-search");
    $updateBtn = $(".wbdv-update");
    $createBtn = $(".wbdv-create");


}


$(init)