export function dateNow() {

    const today = new Date();
    const thisMonth = today.getMonth()+1;
    const formattedMonth = thisMonth.length===2?thisMonth:'0'+thisMonth;
    return today.getFullYear() + '-' + formattedMonth + '-' + today.getDate();

}