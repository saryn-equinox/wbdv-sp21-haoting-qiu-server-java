let $usernameFld;
let $passwordFld;
let $firstNameFld;
let $lastNameFld;
let $roleFLd;
let $tBody;
let $searchBtn;
let $createBtn;
let $editBtn;
let $userRowTemplate;
let userAdminService;

let selectedUser;
let users;
let userById;

/**
 * Create User
 * @param user - user object
 */
const createUser = (user) => {
    userAdminService.createUser(user)
        .then((data) => {
            users.push(data);
            renderUser(users);
        });
}

/**
 * Find all users
 */
const findAllUsers = () => {
    userAdminService.findAllUsers()
        .then((data) => {
            users = data;
            renderUser(users);
        });
}

/**
 * Find user by userId
 * @param userId - the id of user
 */
const findUserById = (userId) => {
    userAdminService.findUserById(userId)
        .then((data) => {
            userById = data;
        });
}

/**
 * Get the information of the selected user
 * @param event - event that selects an user eg user click edit button
 */
const getSelectedUser = (event) => {
    let selectedButton = $(event.target);
    selectedUser = users.find(user => user._id === selectedButton.attr("id"))

    // update table header
    $usernameFld.val(selectedUser.username);
    $roleFLd.val(selectedUser.role);
    $passwordFld.val(selectedUser.password);
    $lastNameFld.val(selectedUser.lastName);
    $firstNameFld.val(selectedUser.firstName);
}

/**
 * Update the information of user and update (or check button) clicked
 * @param event - event that fire this function
 */
const updateUser = (event) => {
    if (selectedUser !== null && selectedUser !== undefined) {
        // update selectedUser value
        selectedUser = {
            "username" : $usernameFld.val(),
            "password" : $passwordFld.val(),
            "lastName" : $lastNameFld.val(),
            "firstName" : $firstNameFld.val(),
            "role" : $roleFLd.val(),
            "_id" : selectedUser._id
        };

        // called updateUser function
        userAdminService.updateUser(selectedUser._id, selectedUser)
            .then((status) => {
                console.log(status);
                userAdminService.findAllUsers()
                    .then((data) => {
                        users = data;
                        renderUser(users);
                    });
            });
        resetInputs();
    } else
        console.log("No user selected for update");
}

/**
 * Delete a user
 * @param event - event that click delete button
 */
const deleteUser = (event) => {
    const selectedButton = $(event.target);
    const idx = selectedButton.attr("id");
    const userId = users[idx]._id;

    userAdminService.deleteUser(userId)
        .then(() => {
            users.splice(idx, 1);
            renderUser(users);
        })
}

/**
 * Render users to the website
 * @param users - users to render (list of objects)
 */
const renderUser = (users) => {
    $tBody.empty();
    console.log(`number of users are ${users.length}`);
    for (var i = 0; i < users.length; i++) {
        const user = users[i];
        $tBody.prepend(`
            <tr class="wbdv-template wbdv-user wbdv-hidden">
                <td class="wbdv-username">${user.username}</td>
                <td>&nbsp;</td>
                <td class="wbdv-first-name">${user.firstName}</td>
                <td class="wbdv-last-name">${user.lastName}</td>
                <td class="wbdv-role">${user.role}</td>
                <td class="wbdv-actions">
                    <span class="float-right">
                        <button type="button" class="btn" >
                            <i class="fa-2x fa fa-times wbdv-remove-btn" id="${i}"></i>
                        </button>
                        <button type="button" class="btn">
                            <i class="fa-2x fa fa-pencil wbdv-modify-btn" id="${user._id}"></i>
                        </button>
                    </span>
                </td>
            </tr>
        `);
    }
    $(".wbdv-remove-btn").click(deleteUser);
    $(".wbdv-modify-btn").click(getSelectedUser)
}

/**
 * Reset input fields
 */
const resetInputs = () => {
    $usernameFld.val("");
    $passwordFld.val("");
    $lastNameFld.val("");
    $firstNameFld.val("");
    $roleFLd.val("Faculty"); // set back to default value
    selectedUser = null; // reset selected user
}

/**
 * executes on document load, when the browser is done parsing the html page
 * and the dom is ready. Retrieved the dom elements needed later in the controller
 * such as the form elements, action icons, and templates. Binds action icons,
 * such as create, update, select, and delete, to respective event handlers
 */
const main = () => {
    $usernameFld = $("#username");
    $passwordFld = $("#password");
    $firstNameFld = $("#first-name");
    $lastNameFld = $("#last-name");
    $roleFLd = $("#role");
    $tBody = $(".wbdv-tbody");
    $searchBtn = $(".wbdv-search-btn");
    $editBtn = $(".wbdv-edit-btn");
    $createBtn = $(".wbdv-create-btn");
    $userRowTemplate = $(".wbdv-template");
    userAdminService = new UserAdminServiceClient();

    users = [];
    selectedUser = null;
    userById = null;

    $createBtn.click(() => {
        createUser({
            "username" : $usernameFld.val(),
            "password" : $passwordFld.val(),
            "lastName" : $lastNameFld.val(),
            "firstName" : $firstNameFld.val(),
            "role" : $roleFLd.val()
        });
        resetInputs();
    });

    $editBtn.click(updateUser);
    findAllUsers();
}

$(main);