$(function(){
    var CATEGORY_API = 'http://localhost:8080/api/categories';
    var nextCategoriesTable = $('#nextCategories');
    var getAllButton = $('#getAll');

    getAllButton.on('click',function () {
        nextCategoriesTable.children().remove();
        $.ajax({
            url: CATEGORY_API,
            type: 'GET'
            }).done(function (result) {
            var newRow = $('<tr></tr>');
            nextCategoriesTable.append(newRow);
            newRow.append($('<th></th>').text('Id'));
            newRow.append($('<th></th>').text('Name'));

            Array.from(result).forEach(function (e) {
                var nextRow = $('<tr></tr>');
                var categoryId = $('<td></td>').text(e.id);
                var categoryName = $('<td></td>').text(e.name);

                nextCategoriesTable.append(nextRow);
                nextRow.append(categoryId);
                nextRow.append(categoryName);
            });
        });
    });
});