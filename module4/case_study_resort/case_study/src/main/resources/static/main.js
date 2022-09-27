function getForm(){
    let valueSelectType = $('#selectType').val();
    if(valueSelectType === '1'){
        $('#room-facility').show();
        $('#villa-facility').hide();
        $('#house-facility').hide();
    }
    if(valueSelectType === '2'){
        $('#house-facility').show();
        $('#room-facility').hide();
        $('#villa-facility').hide();
    }
    if(valueSelectType === '3'){
        $('#villa-facility').show();
        $('#house-facility').show();
        $('#room-facility').hide();
    }
}
